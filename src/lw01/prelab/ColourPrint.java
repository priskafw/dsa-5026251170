package lw01.prelab;
public class ColourPrint extends PrintJob{
    public ColourPrint (String id, int pages) {
        super(id,pages);
    }
    @Override
    public int calculateCharge() {
        int pages = getPages();
        int charge;

        if (pages <=10){
            charge = pages * 1500;
        }else{
            int firstTen = 10 * 1500;
            int rest = (pages - 10) * 1000;
            charge = firstTen + rest;
        }
        charge +=2000;
        return charge;
    }
    @Override
    public String label() {
        return "Colour";
    }
}