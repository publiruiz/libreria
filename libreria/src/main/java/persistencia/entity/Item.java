package persistencia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "item")
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @EmbeddedId
    private long id;
    //Clase Item ; id, book, library,user, status(T,F)
}
