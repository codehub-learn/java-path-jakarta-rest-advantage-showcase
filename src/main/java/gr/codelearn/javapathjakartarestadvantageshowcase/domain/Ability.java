package gr.codelearn.javapathjakartarestadvantageshowcase.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "ability")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String power;
    private Integer duration;
    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonIgnore
    private Player player;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ability ability = (Ability) o;
        return id != null && Objects.equals(id, ability.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}