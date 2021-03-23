package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class tests the functionalities for Country class
 *
 * @author Prathika Suvarna
 */
public class CountryTest extends Country{
    String d_Id;
    String d_Name;
    Country d_Country = new Country();

    /**
     * This method initializes each value before execution of every test case
     *
     * @throws Exception if initialisation fails
     */
    @Before
    public void setUp() throws Exception {

        d_Id = "2";
        d_Country.setId(d_Id);
        d_Name = "Canada";
        d_Country.setName(d_Name);

    }

    @Test
    public void testCountryId(){
        String l_Id = d_Country.getId();
        assertEquals(d_Id,l_Id);
    }


    @Test
    public void testCountryName(){
        String l_Name = d_Country.getName();
        assertEquals(d_Name,l_Name);
    }

}
