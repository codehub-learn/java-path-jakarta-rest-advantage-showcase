package gr.codelearn.javapathjakartarestadvantageshowcase.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Pattern(regexp = "^[A-Z].*[\\s\\.]*$",message = "{player.name.uppercase}")
    private String name;
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthdate;
    private BigDecimal height;
    @NotNull(message = "{player.hp.null}")
    private Integer hp;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "player",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Ability> abilities = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id != null && Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
