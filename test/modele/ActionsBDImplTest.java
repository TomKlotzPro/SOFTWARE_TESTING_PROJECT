package modele;

import org.junit.jupiter.api.*;
import utils.Constantes;
import utils.ConstantesTest;

import java.sql.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActionsBDImplTest {
    private final ActionsBDImpl db = new ActionsBDImpl();
    private final ProgrammeurBean testBean = getProgrammerBeanTest();

    @BeforeAll
    public static void init() throws SQLException {
        Connection dbConn = DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.MDP);
        Statement stmt = dbConn.createStatement();
        try {
            stmt.executeUpdate(ConstantesTest.DROP_TABLE);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try {
            stmt.executeUpdate(ConstantesTest.CREATE_TABLE);
        }
        catch (SQLException e){
            fail("Can't create table");
        }
        stmt.close();
        dbConn.close();
    }

    @Test
    @Order(1)
    public void isTableEmptyAtStart(){
        assertEquals(0, db.getProgrammeurs().size());
    }

    @Test
    @Order(2)
    public void addProgrammer(){
        addProgrammerBean(testBean);
    }

    @Test
    @Order(3)
    public void getProgrammerByMatricule(){
        ProgrammeurBean result = db.getProgrammeur(testBean.getMatricule());
        assertNotSame(testBean, result);
    }

    @Test
    @Order(4)
    public void modifyProgrammer(){
        testBean.setPseudo("TheUltraTester");
        modifyProgrammerBean(testBean);
    }

    @Test
    @Order(5)
    public void getAllProgrammer(){
        ArrayList result = db.getProgrammeurs();
        assertEquals(1, result.size());
        assertNotSame(testBean, result.get(0));
    }

    @Test
    @Order(6)
    public void deleteProgrammer(){
        deleteProgrammerBean(testBean);
    }

    @Test
    @Order(7)
    public void isTableEmptyAtEnd(){
        assertEquals(0, db.getProgrammeurs().size());
    }

    private void addProgrammerBean(ProgrammeurBean bean)
    {
        Date date_naiss = bean.getDate_naiss();
        Date date_emb = bean.getDate_emb();
        db.ajouterProgrammeur(bean.getMatricule(),
                bean.getNom(),
                bean.getPrenom(),
                bean.getAdresse(),
                bean.getPseudo(),
                bean.getResponsable(),
                bean.getHobby(),
                Integer.toString(date_naiss.getDay()),
                Integer.toString(date_naiss.getMonth()),
                Integer.toString(date_naiss.getYear()),
                Integer.toString(date_emb.getDay()),
                Integer.toString(date_emb.getMonth()),
                Integer.toString(date_emb.getYear()));
    }

    private void modifyProgrammerBean(ProgrammeurBean bean)
    {
        Date date_naiss = bean.getDate_naiss();
        Date date_emb = bean.getDate_emb();
        db.modifierProgrammeur(bean.getMatricule(),
                bean.getNom(),
                bean.getPrenom(),
                bean.getAdresse(),
                bean.getPseudo(),
                bean.getResponsable(),
                bean.getHobby(),
                Integer.toString(date_naiss.getDay()),
                Integer.toString(date_naiss.getMonth()),
                Integer.toString(date_naiss.getYear()),
                Integer.toString(date_emb.getDay()),
                Integer.toString(date_emb.getMonth()),
                Integer.toString(date_emb.getYear()));
    }

    private void deleteProgrammerBean(ProgrammeurBean bean)
    {
        db.supprimerProgrammeur(bean.getMatricule());
    }

    private static ProgrammeurBean getProgrammerBeanTest(){
        ProgrammeurBean bean = new ProgrammeurBean();
        bean.setAdresse("TestTown");
        bean.setDate_emb(new Date(2020, 11, 17));
        bean.setDate_naiss(new Date(1998, 1, 1));
        bean.setHobby("testing");
        bean.setMatricule("1");
        bean.setNom("Doe");
        bean.setPrenom("John");
        bean.setPseudo("UltraTester");
        bean.setResponsable("No one");
        return bean;
    }

}
