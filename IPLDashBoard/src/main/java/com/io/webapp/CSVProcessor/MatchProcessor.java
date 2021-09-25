package com.io.webapp.CSVProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.io.webapp.data.MatchInput;
import com.io.webapp.models.Match;

public class MatchProcessor implements ItemProcessor<MatchInput, Match> {

	private static final Logger log = LoggerFactory.getLogger(MatchProcessor.class);

	@Override
	public Match process(MatchInput item) throws Exception {

		Match match = new Match();
		match.
		item.
	}
}
