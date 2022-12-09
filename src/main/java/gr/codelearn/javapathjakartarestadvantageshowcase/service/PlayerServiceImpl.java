package gr.codelearn.javapathjakartarestadvantageshowcase.service;

import gr.codelearn.javapathjakartarestadvantageshowcase.domain.Ability;
import gr.codelearn.javapathjakartarestadvantageshowcase.domain.Player;
import gr.codelearn.javapathjakartarestadvantageshowcase.repository.AbstractRepository;
import gr.codelearn.javapathjakartarestadvantageshowcase.repository.PlayerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PlayerServiceImpl extends AbstractService<Player> implements PlayerService{
    @Inject
    PlayerRepository playerRepository;
    @Override
    public AbstractRepository<Player, Long> getRepository() {
        return playerRepository;
    }


    public void addAbility(Long playerId, Ability ability){
        Player player = playerRepository.get(playerId);
        ability.setPlayer(player);
        player.getAbilities().add(ability);
        playerRepository.update(player);
    }
}
