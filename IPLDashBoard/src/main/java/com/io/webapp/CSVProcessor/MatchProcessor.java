package com.io.webapp.CSVProcessor;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.io.webapp.data.MatchInput;
import com.io.webapp.models.Match;

public class MatchProcessor implements ItemProcessor<MatchInput, Match> {

	private static final Logger log = LoggerFactory.getLogger(MatchProcessor.class);

	@Override
	public Match process(MatchInput item) throws Exception {

		log.info("Inside Process Method");
		Match match = new Match();
		match.setId(Long.parseLong(item.getId()));
		match.setCity(item.getCity());
		match.setDate(LocalDate.parse(item.getDate()));
		match.setPlayerOfMatch(item.getPlayer_of_match());

		String firstInnTeam, secondInnTeam;
		if ("bat".equals(item.getToss_decision())) {
			firstInnTeam = item.getToss_winner();
			secondInnTeam = item.getToss_winner().equals(item.getTeam1()) ? item.getTeam1() : item.getTeam2();
		} else {
			secondInnTeam = item.getToss_winner();
			firstInnTeam = item.getToss_winner().equals(item.getTeam1()) ? item.getTeam1() : item.getTeam2();

		}

		match.setTeam1(firstInnTeam);
		match.setTeam2(secondInnTeam);
		match.setTossDecision(item.getToss_decision());
		match.setTossWinner(item.getToss_winner());
		match.setResult(item.getResult());
		match.setResultMargin(item.getResult_margin());
		match.setUmpire1(item.getUmpire1());
		match.setUmpire2(item.getUmpire2());

		return match;
	}
}
