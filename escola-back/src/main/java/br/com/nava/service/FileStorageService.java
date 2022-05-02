package br.com.nava.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.stream.Stream;

import org.springframework.core.io.*;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

	private final Path root = Paths.get("uploads");
	
	public void save(MultipartFile file) {
		try {
			Files.createDirectories(root);
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
		}catch(Exception e) {
			throw new RuntimeException("Não foi possível gravar o arquivo!" + e.getMessage());
		}		
	}
	
	public Resource load(String filename) {
		try {
			Path file = root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if(resource.exists() || resource.isReadable()) {
				return resource;
			}else {
				throw new RuntimeException("Arquivo não pode ser lido");
			}
		}catch(MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}
	
	public Stream<Path> listarTodosArquivos(){
		try {
			return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		}catch(IOException e) {
		throw new RuntimeException("Não conseguimos ler os arquivos");
		}
	}


	public void deleteAll() {
		FileSystemUtils.deleteRecursively(root.toFile());
		
	}
}