package web.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "autorities")
@Getter
@Setter
public class Role implements GrantedAuthority {

    private Long id;
    private String role;

    public void setRole (String role) {
        this.role = role;
    }

    @Override
    public String getAuthority () {
        return role;
    }
}
