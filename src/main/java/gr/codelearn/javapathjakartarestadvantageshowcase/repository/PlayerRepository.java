package gr.codelearn.javapathjakartarestadvantageshowcase.repository;

import gr.codelearn.javapathjakartarestadvantageshowcase.domain.Player;
import jakarta.ejb.Stateless;

import java.util.List;


@Stateless
public class PlayerRepository extends AbstractRepository<Player,Long> {
    @Override
    public Class<Player> getClassType() {
        return Player.class;
    }

    @Override
    public List<Player> findAll() {
        return  em.createQuery("select p from Player p left join fetch p.abilities").getResultList();
    }

    @Override
    public Player get(Long id) {
        return  em.createQuery("select p from Player p left join fetch p.abilities where p.id=:id", Player.class)
                .setParameter("id",id)
                .getSingleResult();
    }


    public Player update(Player player) {
        return  em.merge(player);
    }
}
