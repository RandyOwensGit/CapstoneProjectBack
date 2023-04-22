package randyowens.seniorproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@MappedSuperclass
public abstract class DateCreationEntity {

    @Column( name = "date_created", nullable = false, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    protected Date getDateCreated() {
        return this.dateCreated;
    }

}
