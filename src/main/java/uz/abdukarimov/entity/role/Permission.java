package uz.abdukarimov.entity.role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;

    public String getName() {
        return name;
    }

    public Permission(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
