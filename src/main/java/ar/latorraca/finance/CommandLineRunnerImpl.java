package ar.latorraca.finance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

	final static Logger logger = LoggerFactory.getLogger(CommandLineRunnerImpl.class);

	@Override
	public void run(String... args) throws Exception {

		logger.info("++++++ BEGIN ---> CommandLineRunner ++++++");
		logger.info("++++++ END ---> CommandLineRunner ++++++");

	}

}
