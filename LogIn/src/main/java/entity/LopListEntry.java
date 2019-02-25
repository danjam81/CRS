package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author q271820
 */
public class LopListEntry {
    
    public enum Status {
        PENDING,
        ACTIVE,
        INACTIVE,
        DONE;
        
        public static List<Status> getValues() {
            return Status.getValues();
        }
    }
    
    private String itemId;
    private String subject;
    private Date dueDate;
    private String notes;
    private Status status;
    private String owner;
    


    public LopListEntry() {
        // needed for JPA!!!!!
    }
    
    public LopListEntry(String subject, String owner, Date dueDate, Status status) {
        setSubject(subject);
        setOwner(owner);
        setDueDate(dueDate);
        setStatus(status);
    }
    
    public LopListEntry(String subject, String owner, Date dueDate, String status, String notes) {
        setSubject(subject);
        setOwner(owner);
        setDueDate(dueDate);
        setStatusByString(status);
        setNotes(notes);
    }
    
    public LopListEntry(String subject, String owner, String dueDate, String status, String notes) {
        
        setStatusByString(status);
        setSubject(subject);
        setOwner(owner);
        setNotes(notes);
        setDueDateByString(dueDate);
    }
    
    public void setStatusByString(String status) {
        switch (status) {
			case "ACTIVE":
				setStatus(Status.ACTIVE);
                                break;
			case "INACTIVE":
				setStatus(Status.INACTIVE);
                                break;
                        case "DONE":
				setStatus(Status.DONE);
                                break;
			default:
				setStatus(Status.PENDING);
                                break;
			}
    }
    
    public void setDueDateByString(String dueDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        Date date;
        try {
            date = sdf.parse(dueDate);
        } catch (ParseException ex) {
            date = new Date();
        }
        setDueDate(date);
    }
    
    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDueDateAsString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(getDueDate());
    }
    
    public String getEntryAsJson() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        
        
        String jsonData ="{\"itemId\":\"" + this.getItemId() + "\",\"subject\":\""+this.getSubject()+"\",\"dueDate\":\""+sdf.format(getDueDate())+"\",\"notes\":\""+this.getNotes()+"\",\"status\":\""+this.getStatus()+"\",\"owner\":\""+this.getOwner()+"\"}";
        return jsonData;
    }
    
}
