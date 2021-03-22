/*
Jack Blair 2/2/21
MIT Lisence by BruhLab
Java Development Resources - Quaratine CompSci
*/

public class President{
    public int startTerm = 0;
    public int endTerm = 0;

    public String name = "";
    public String firstLady = "";
    public String vicePresident = "";

    public President(String line){
        String[] data = line.split(",");
        if(data[0].contains("-")){
            String[] years = data[0].split("-");
            startTerm = Integer.parseInt(years[0]);
            endTerm = Integer.parseInt(years[1]);
        }
        else{
            //Only Lasted one year
            startTerm = Integer.parseInt(data[0]);
            endTerm = Integer.parseInt(data[0]);
        }

        name = data[1];
        firstLady = data[2];

        if(data[3] == "office vacant")
            vicePresident = "";
        else
            vicePresident = data[3];
    }

    public President(int startYear, int endYear, String nombre, String firstlady, String vice){
        startTerm = startYear;
        endTerm = endYear;
        name = nombre;
        firstLady = firstlady;
        vicePresident = vice;
    }

    public String toString(){
        return null;
        //Write a representation of the data that the user can understand
    }
}