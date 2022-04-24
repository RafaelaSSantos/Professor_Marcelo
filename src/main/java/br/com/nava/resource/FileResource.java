package br.com.nava.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.nava.constantes.Messages;
import br.com.nava.model.FileInfo;
import br.com.nava.service.FileStorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name=Messages.SWAGGER_TAG_FILE)
@RestController
@RequestMapping("/arquivo")
public class FileResource {

	@Autowired
	private FileStorageService storageService;
	
	//salvar arquivo em pasta
	@Operation(description = Messages.SWAGGER_FILE_POST)
	@PostMapping(consumes = {"multipart/form-data"})
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file){
		try {
			storageService.save(file);
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			
			String urlDownload = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/uploads/").path(fileName).toUriString();
			return ResponseEntity.ok().body("Arquivo enviado com sucesso -> " + urlDownload );
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Não pode ser feito o upload");
		}
	}
	
	//realizar o download do arquivo que esta salvo em pasta
	@Operation(description = Messages.SWAGGER_FILE_GET)
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename){
		Resource file = storageService.load(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, 
				"attachment; filename=\"" + file.getFilename() +"\"").body(file);
	}
	
	
	//listar os arquivo em pasta
	@Operation(description = Messages.SWAGGER_FILE_GET_ALL)
	@GetMapping("/arquivos")
	public ResponseEntity<List<FileInfo>> listarTodosArquivos(){
		List<FileInfo> fileInfos = storageService.listarTodosArquivos().map(
				path -> {
					String filename = path.getFileName().toString();
					String url = MvcUriComponentsBuilder.fromMethodName(FileResource.class,"getFile", path.getFileName().toString()).build().toString();					
					return new FileInfo(filename, url);
				}).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(fileInfos);
	}
	
	//Deletar todos os arquivos
	@Operation(description = Messages.SWAGGER_FILE_DELETE)
	@GetMapping("/excluirTodosArquivos")
	public ResponseEntity<String> excluirArquivos(){
		storageService.deleteAll();
		return ResponseEntity.ok().body("Arquivos excluidos com sucesso!");
	}
}