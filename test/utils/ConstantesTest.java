package utils;

public class ConstantesTest {
    public static final String DROP_TABLE = "DROP TABLE PROGRAMMEUR";
    public static final String CREATE_TABLE = "CREATE TABLE PROGRAMMEUR (\n" +
            "\tID INTEGER NOT NULL AUTO_INCREMENT,\n" +
            "\tMATRICULE VARCHAR(10),\n" +
            "\tNOM VARCHAR(35),\n" +
            "\tPRENOM VARCHAR(35),\n" +
            "  ADRESSE VARCHAR(150),\n" +
            "\tPSEUDO VARCHAR(20),\n" +
            "\tRESPONSABLE VARCHAR(30),\n" +
            "\tHOBBY VARCHAR(10),\n" +
            "\tDATE_NAISS DATE,\n" +
            "\tDATE_EMB DATE,\n" +
            "\tPRIMARY KEY (ID)\n" +
            ")";
}
