package tr.com.eis.entity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Title extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4902071486871066776L; 
    private Long id;
    private String name;
    private Double minSalary;
    private Double maxSalary;
    private String definition;
    private String defCode;
     @OneToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "title_id", nullable = false)
    private Company company;

}
