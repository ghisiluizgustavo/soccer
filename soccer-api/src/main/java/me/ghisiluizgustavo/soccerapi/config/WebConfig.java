package me.ghisiluizgustavo.soccerapi.config;

import me.ghisiluizgustavo.soccerapi.config.converters.player.PlayerToRecordConverter;
import me.ghisiluizgustavo.soccerapi.config.converters.player.RecordToPlayerConverter;
import me.ghisiluizgustavo.soccerapi.config.converters.team.RecordToTeamConverter;
import me.ghisiluizgustavo.soccerapi.config.converters.team.TeamToRecordConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new PlayerToRecordConverter());
        registry.addConverter(new RecordToPlayerConverter());
        registry.addConverter(new TeamToRecordConverter());
        registry.addConverter(new RecordToTeamConverter());
    }
}
