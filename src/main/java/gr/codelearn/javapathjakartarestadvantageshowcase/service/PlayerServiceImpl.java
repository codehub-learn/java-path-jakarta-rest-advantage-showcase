package gr.codelearn.javapathjakartarestadvantageshowcase.service;

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
}
