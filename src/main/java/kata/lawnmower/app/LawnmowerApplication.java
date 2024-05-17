package kata.lawnmower.app;

import kata.lawnmower.app.adapters.TextFileAdapter;
import kata.lawnmower.app.adapters.impl.TextFileAdapterImpl;
import kata.lawnmower.app.exception.FileNotFoundException;
import kata.lawnmower.domain.service.impl.LawnMowerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@SpringBootApplication
public class LawnmowerApplication implements CommandLineRunner {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(LawnmowerApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		final TextFileAdapter fileAdapter = new TextFileAdapterImpl(new LawnMowerServiceImpl());
		if(args == null || args.length == 0) {
			log.error("Filename is mandatory");
			throw new FileNotFoundException("Filename is mandatory");
		}
		log.info("file {}",args[0]);
		final var inputStream = Files.newInputStream(Path.of(args[0]));
		String result = fileAdapter.moveMowers(inputStream);
		log.info("Result : {}", result);
	}
}
