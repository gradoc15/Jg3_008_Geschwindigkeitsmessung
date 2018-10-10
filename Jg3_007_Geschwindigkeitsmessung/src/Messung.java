
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Messung implements Serializable
{
    private LocalDate date;
    private LocalTime time;
    private String kennzeichen;
    private int gemessen;
    private int erlaubt;

    public Messung(LocalDate date, LocalTime time, String kennzeichen, int gemessen, int erlaubt)
    {
        this.date = date;
        this.time = time;
        this.kennzeichen = kennzeichen;
        this.gemessen = gemessen;
        this.erlaubt = erlaubt;
    }

    public int getUebertretung()
    {
        return gemessen-erlaubt;
    }
    
    
    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }

    public String getKennzeichen()
    {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen)
    {
        this.kennzeichen = kennzeichen;
    }

    public int getGemessen()
    {
        return gemessen;
    }

    public void setGemessen(int gemessen)
    {
        this.gemessen = gemessen;
    }

    public int getErlaubt()
    {
        return erlaubt;
    }

    public void setErlaubt(int erlaubt)
    {
        this.erlaubt = erlaubt;
    }
    
    
    
}
