public  class Tasks {

    private int id;
    private String description;
    private String category;
    private int priority;
    private boolean isComplete;


    public Tasks(int id, String description, String category, int priority, boolean isComplete){
        this.id = id;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.isComplete = isComplete;
        
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public int getPriority() {
        return priority;
    }


    public void setPriority(int priority) {
        this.priority = priority;
    }


    public boolean isComplete() {
        return isComplete;
    }


    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void markComplete() { 
        this.isComplete = true; 
    }

    @Override
    public String toString() {
        return String.format("| %-3d | %-40s | %-15s | %-8d | %-10s |",
                id, description, category, priority, isComplete ? "Complete" : "Pending");
    }



}



