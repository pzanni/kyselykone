
package wad.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Poll extends AbstractPersistable<Long>{
    
    private String title;
    @ManyToOne
    private Asker asker;
    @OneToMany
    private List<Option> options;
    private String maker;
    
    
    public Poll() {
        options = new ArrayList();
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String t) {
        title = t;
    }
    
    public Asker getAsker() {
        return asker;
    }
    
    public String getMaker() {
        return maker;
    }
    
    public void setAsker(Asker a) {
        asker = a;
        maker = a.getUsername();
    }
    
    public List<Option> getOptions() {
        return options;
    }
    
    public void addOption(Option o) {
        options.add(o);
    }
}
