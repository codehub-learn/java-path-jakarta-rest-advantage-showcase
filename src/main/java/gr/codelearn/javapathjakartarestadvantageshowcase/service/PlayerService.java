package gr.codelearn.javapathjakartarestadvantageshowcase.service;

import gr.codelearn.javapathjakartarestadvantageshowcase.domain.Ability;
import gr.codelearn.javapathjakartarestadvantageshowcase.domain.Player;

public interface PlayerService extends BaseService<Player,Long>{
    void addAbility(Long playerId, Ability ability);
}
