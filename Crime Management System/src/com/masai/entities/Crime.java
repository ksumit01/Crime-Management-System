package com.masai.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Crime implements Serializable{
    private  int crimeId;
    private String type;
    private String description;
    private String psArea;
    private LocalDate date;
    private String victimName;
    
    public Crime() {
        super();
    }

    public Crime(int crimeId, String type, String description, String psArea, LocalDate date, String victimName) {
        super();
        this.crimeId = crimeId;
        this.type = type;
        this.description = description;
        this.psArea = psArea;
        this.date = date;
        this.victimName = victimName;
    }

    public int getCrimeId() {
        return crimeId;
    }

    public void setCrimeId(int crimeId) {
        this.crimeId = crimeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPsArea() {
        return psArea;
    }

    public void setPsArea(String psArea) {
        this.psArea = psArea;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getVictimName() {
        return victimName;
    }

    public void setVictimName(String victimName) {
        this.victimName = victimName;
    }
    

    @Override
    public String toString() {
        return "Crime [crimeId=" + crimeId + ", type=" + type + ", description=" + description + ", psArea=" + psArea
                + ", date=" + date + ", victimName=" + victimName + "]";
    }

	@Override
	public int hashCode() {
		return Objects.hash(crimeId, date, description, psArea, type, victimName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crime other = (Crime) obj;
		return crimeId == other.crimeId && Objects.equals(date, other.date)
				&& Objects.equals(description, other.description) && Objects.equals(psArea, other.psArea)
				&& Objects.equals(type, other.type) && Objects.equals(victimName, other.victimName);
	}
}

