package utils;



public class Constants {
    public static final String PACKAGE = "utils";
    public static final String PROPERTIES_PATH = "enviroment";
    
    
    public static final String ROOF_MATERIAL_CSV = "ROOF_MATERIAL_CSV";    
    public static final String BASEMENT_MATERIAL_CSV = "BASEMENT_MATERIAL_CSV";
    public static final String MAIN_PART_MATERIAL_CSV = "MAIN_PART_MATERIAL_CSV";
    public static final String MAIN_PART_TEMPLATE_CSV = "MAIN_PART_TEMPLATE_CSV";
    public static final String ROOF_TEMPLATE_CSV = "ROOF_TEMPLATE_CSV";
    public static final String BASEMENT_TEMPLATE_CSV = "BASEMENT_TEMPLATE_CSV";
    public static final String BUILDING_TEMPLATE_CSV = "BUILDING_TEMPLATE_CSV";
    public static final String CALCULATOR_CSV = "CALCULATOR_CSV";
    
    
    
    
    public static final String ROOF_MATERIAL_XML = "ROOF_MATERIAL_XML";
    public static final String BASEMENT_MATERIAL_XML = "BASEMENT_MATERIAL_XML";
    public static final String MAIN_PART_MATERIAL_XML = "MAIN_PART_MATERIAL_XML";
    public static final String MAIN_PART_TEMPLATE_XML = "MAIN_PART_TEMPLATE_XML";
    public static final String ROOF_TEMPLATE_XML = "ROOF_TEMPLATE_XML";
    public static final String BASEMENT_TEMPLATE_XML = "BASEMENT_TEMPLATE_XML";
    public static final String BUILDING_TEMPLATE_XML = "BUILDING_TEMPLATE_XML";
    
    public static final String DB_DRIVER = "DB_DRIVER";
    public static final String DB_CONNECT = "DB_CONNECT";
    public static final String DB_USER = "DB_USER";
    public static final String DB_PASS = "DB_PASS";
    
    public static final String CREATE_TABLE_ROOF_M="CREATE TABLE IF NOT EXISTS ROOFMATERIAL ( id long UNIQUE NOT NULL , name char(50) NOT NULL , price double NOT NULL , durabilityYears int NOT NULL )";
    public static final String CREATE_TABLE_MAIN_PART_M="CREATE TABLE IF NOT EXISTS MAINPARTMATERIAL ( id long UNIQUE NOT NULL , name char(50) NOT NULL, price double NOT NULL, soundTransmission double NOT NULL )";
    public static final String CREATE_TABLE_BASEMENT_M="CREATE TABLE IF NOT EXISTS BASEMENTMATERIAL ( id long UNIQUE NOT NULL , name char(50) NOT NULL, price double NOT NULL, frostresistance int NOT NULL , waterproof int NOT NULL)";
    public static final String CREATE_TABLE_ROOF_T=" CREATE TABLE IF NOT EXISTS rooftemplate ( id long UNIQUE NOT NULL , name char(50) NOT NULL, pricemultiplier double NOT NULL, id_material long NOT NULL, insulation boolean NOT NULL, pipe boolean NOT NULL, FOREIGN KEY (id_material ) REFERENCES roofmaterial(id) ON DELETE SET NULL ON UPDATE CASCADE )";
    public static final String CREATE_TABLE_BASEMENT_T="CREATE TABLE IF NOT EXISTS basementtemplate ( id long UNIQUE NOT NULL , name char(50) NOT NULL, pricemultiplier double NOT NULL, id_material long NOT NULL, cellar boolean NOT NULL, FOREIGN KEY (id_material ) REFERENCES basementmaterial(id) ON DELETE SET NULL ON UPDATE CASCADE )";
    public static final String CREATE_TABLE_MAIN_PART_T="CREATE TABLE IF NOT EXISTS mainparttemplate ( id long UNIQUE NOT NULL , name char(50) NOT NULL, pricemultiplier double NOT NULL, id_material long NOT NULL,  veranda boolean NOT NULL, windows int NOT NULL, FOREIGN KEY (id_material ) REFERENCES mainpartmaterial(id) ON DELETE SET NULL  ON UPDATE CASCADE )";
    public static final String CREATE_TABLE_BUILDING_T="CREATE TABLE IF NOT EXISTS buildingtemplate ( id long NOT NULL, name char(50) NOT NULL, id_roof_template long NOT NULL, id_main_part_template long NOT NULL, id_basement_template long NOT NULL, FOREIGN KEY (id_roof_template ) REFERENCES rooftemplate(id) ON DELETE SET NULL ON UPDATE CASCADE , FOREIGN KEY (id_main_part_template ) REFERENCES mainparttemplate(id) ON DELETE SET NULL ON UPDATE CASCADE, FOREIGN KEY (id_basement_template ) REFERENCES basementtemplate(id) ON DELETE SET NULL ON UPDATE CASCADE )";
    
    public static final String INSERT_TABLE_ROOF_M="INSERT INTO ROOFMATERIAL VALUES (1, 'aaa',1.5,1 ), (2, 'bbb', 2.5,3), (3, 'ccc', 3,5);";
    public static final String INSERT_TABLE_MAIN_PART_M="INSERT INTO MAINPARTMATERIAL VALUES (1, 'aaa',1.5,1.0 ), (2, 'bbb', 2.5,3.0), (3, 'ccc', 3,5.0);";
    public static final String INSERT_TABLE_BASEMENT_M="INSERT INTO BASEMENTMATERIAL VALUES (1, 'aaa',1,1,1 ), (2, 'bbb', 2,3,3), (3, 'ccc', 3,5,2);";
    public static final String INSERT_TABLE_ROOF_T="INSERT INTO ROOFTEMPLATE VALUES (1, 'aaa',1.0,1,true,true ), (2, 'bbb', 2,2,false,true); ";
    public static final String INSERT_TABLE_BASEMENT_T="INSERT INTO BASEMENTTEMPLATE VALUES (1, 'aaa',1.0,1,true ), (2, 'bbb', 2,2,false);  ";
    public static final String INSERT_TABLE_MAIN_PART_T="INSERT INTO MAINPARTTEMPLATE VALUES (1, 'aaa',1.0,1,true,3 ), (2, 'bbb', 2,2,false,5); ";
    public static final String INSERT_TABLE_BUILDING_T="INSERT INTO BUILDINGTEMPLATE VALUES (123, 'aaa',2,1,1 );";
    
    public static final String INSERT_ROOF_MATERIAL = "INSERT INTO ROOFMATERIAL VALUES (?,?,?,?)";
    public static final String ROOF_MATERIAL_ID = "id";
    public static final String ROOF_MATERIAL_NAME = "name";
    public static final String ROOF_MATERIAL_PRICE = "price";
    public static final String ROOF_MATERIAL_DURABILITY_YEARS ="durabilityYears";
    public static final String ROOF_MATERIAL_COUNT_COLUMN="count(id)";
    public static final int ROOF_MATERIAL_ID_INDEX=1;
    public static final int ROOF_MATERIAL_NAME_INDEX=2;
    public static final int ROOF_MATERIAL_PRICE_INDEX=3;
    public static final int ROOF_MATERIAL_DURABILITY_YEARS_INDEX =4;
    public static final int ROOF_MATERIAL_ID_UPDATE_INDEX=5;
    public static final String SELECT_ROOF_MATERIAL = "SELECT * FROM ROOFMATERIAL ";
    public static final String DELETE_ROOF_MATERIAL = " DELETE FROM ROOFMATERIAL WHERE id= (?)";
    public static final String UPDATE_ROOF_MATERIAL = "UPDATE ROOFMATERIAL SET id=(?), name=(?), price=(?),durabilityYears=(?) WHERE id=(?)";
    public static final String COUNT_ROOF_MATERIAL="SELECT count(id) FROM ROOFMATERIAL";
    
    public static final String INSERT_BASEMENT_MATERIAL = "INSERT INTO BASEMENTMATERIAL VALUES (?,?,?,?,?)";
    public static final String BASEMENT_MATERIAL_ID = "id";
    public static final String BASEMENT_MATERIAL_NAME = "name";
    public static final String BASEMENT_MATERIAL_PRICE = "price";
    public static final String BASEMENT_MATERIAL_FROST_RESISTANCE="frostResistance";
    public static final String BASEMENT_MATERIAL_WATERPROOF ="waterproof";
    public static final int BASEMENT_MATERIAL_ID_INDEX=1;
    public static final int BASEMENT_MATERIAL_NAME_INDEX=2;
    public static final int BASEMENT_MATERIAL_PRICE_INDEX=3;
    public static final int BASEMENT_MATERIAL_FROST_RESISTANCE_INDEX =4;
    public static final int BASEMENT_MATERIAL_WATERPROOF_INDEX =5;
    public static final int BASEMENT_MATERIAL_ID_UPDATE_INDEX=6;
    public static final String SELECT_BASEMENT_MATERIAL = "SELECT * FROM BASEMENTMATERIAL ";
    public static final String DELETE_BASEMENT_MATERIAL = " DELETE FROM BASEMENTMATERIAL WHERE id= (?)";
    public static final String UPDATE_BASEMENT_MATERIAL = "UPDATE BASEMENTMATERIAL SET id=(?), name=(?), price=(?),frostResistance=(?),waterproof=(?) WHERE id=(?)";
    
    public static final String INSERT_MAIN_PART_MATERIAL = "INSERT INTO MAINPARTMATERIAL VALUES (?,?,?,?)";
    public static final String MAIN_PART_MATERIAL_ID = "id";
    public static final String MAIN_PART_MATERIAL_NAME = "name";
    public static final String MAIN_PART_MATERIAL_PRICE = "price";
    public static final String MAIN_PART_MATERIAL_SOUND_TRANSMISSION ="soundTransmission";
    public static final int MAIN_PART_MATERIAL_ID_INDEX=1;
    public static final int MAIN_PART_MATERIAL_NAME_INDEX=2;
    public static final int MAIN_PART_MATERIAL_PRICE_INDEX=3;
    public static final int MAIN_PART_MATERIAL_SOUND_TRANSMISSION_INDEX=4;
    public static final int MAIN_PART_MATERIAL_ID_UPDATE_INDEX=5;
    public static final String SELECT_MAIN_PART_MATERIAL = "SELECT * FROM MAINPARTMATERIAL ";
    public static final String DELETE_MAIN_PART_MATERIAL = " DELETE FROM MAINPARTMATERIAL WHERE id= (?)";
    public static final String UPDATE_MAIN_PART_MATERIAL = "UPDATE MAINPARTMATERIAL SET id=(?), name=(?), price=(?),soundTransmission=(?) WHERE id=(?)";
    
    public static final String INSERT_MAIN_PART_TEMPLATE = "INSERT INTO MAINPARTTEMPLATE VALUES (?,?,?,?,?,?)";
    public static final String MAIN_PART_TEMPLATE_ID = "id";
    public static final String MAIN_PART_TEMPLATE_NAME = "name";
    public static final String MAIN_PART_TEMPLATE_PRICEMULTIPLIER = "pricemultiplier";
    public static final String MAIN_PART_TEMPLATE_IDMATERIAL = "id_material";
    public static final String MAIN_PART_TEMPLATE_VERANDA = "veranda";
    public static final String MAIN_PART_TEMPLATE_WINDOWS = "windows";
    public static final int MAIN_PART_TEMPLATE_ID_INDEX=1;
    public static final int MAIN_PART_TEMPLATE_NAME_INDEX=2;
    public static final int MAIN_PART_TEMPLATE_PRICEMULTIPLIER_INDEX=3;
    public static final int MAIN_PART_TEMPLATE_ID_MATERIAL_INDEX=4;
    public static final int MAIN_PART_TEMPLATE_VERANDA_INDEX = 5;
    public static final int MAIN_PART_TEMPLATE_WINDOWS_INDEX = 6;
    public static final int MAIN_PART_TEMPLATE_ID_UPDATE_INDEX=7;
    public static final String SELECT_MAIN_PART_TEMPLATE = "SELECT * FROM MAINPARTTEMPLATE ";
    public static final String DELETE_MAIN_PART_TEMPLATE = " DELETE FROM MAINPARTTEMPLATE WHERE id= (?)";
    public static final String UPDATE_MAIN_PART_TEMPLATE = "UPDATE MAINPARTTEMPLATE SET id=(?), name=(?), pricemultiplier=(?),id_material=(?),veranda=(?),windows=(?) WHERE id=(?)";
    
    public static final String INSERT_ROOF_TEMPLATE = "INSERT INTO ROOFTEMPLATE VALUES (?,?,?,?,?,?)";
    public static final String ROOF_TEMPLATE_ID = "id";
    public static final String ROOF_TEMPLATE_NAME = "name";
    public static final String ROOF_TEMPLATE_PRICEMULTIPLIER = "pricemultiplier";
    public static final String ROOF_TEMPLATE_IDMATERIAL = "id_material";
    public static final String ROOF_TEMPLATE_INSULATION = "insulation";
    public static final String ROOF_TEMPLATE_PIPE = "pipe";
    public static final int ROOF_TEMPLATE_ID_INDEX=1;
    public static final int ROOF_TEMPLATE_NAME_INDEX=2;
    public static final int ROOF_TEMPLATE_PRICEMULTIPLIER_INDEX=3;
    public static final int ROOF_TEMPLATE_ID_MATERIAL_INDEX=4;
    public static final int ROOF_TEMPLATE_INSULATION_INDEX =5;
    public static final int ROOF_TEMPLATE_PIPE_INDEX =6;
    public static final int ROOF_TEMPLATE_ID_UPDATE_INDEX=7;
    public static final String SELECT_ROOF_TEMPLATE = "SELECT * FROM ROOFTEMPLATE ";
    public static final String DELETE_ROOF_TEMPLATE = " DELETE FROM ROOFTEMPLATE WHERE id= (?)";
    public static final String UPDATE_ROOF_TEMPLATE = "UPDATE ROOFTEMPLATE SET id=(?), name=(?), pricemultiplier=(?),id_material=(?),insulation=(?),pipe=(?) WHERE id=(?)";
    
    public static final String INSERT_BASEMENT_TEMPLATE = "INSERT INTO BASEMENTTEMPLATE VALUES (?,?,?,?,?)";
    public static final String BASEMENT_TEMPLATE_ID = "id";
    public static final String BASEMENT_TEMPLATE_NAME = "name";
    public static final String BASEMENT_TEMPLATE_PRICEMULTIPLIER = "pricemultiplier";
    public static final String BASEMENT_TEMPLATE_IDMATERIAL = "id_material";
    public static final String BASEMENT_TEMPLATE_CELLAR= "cellar";
    public static final int BASEMENT_TEMPLATE_ID_INDEX=1;
    public static final int BASEMENT_TEMPLATE_NAME_INDEX=2;
    public static final int BASEMENT_TEMPLATE_PRICEMULTIPLIER_INDEX=3;
    public static final int BASEMENT_TEMPLATE_ID_MATERIAL_INDEX=4;
    public static final int BASEMENT_TEMPLATE_CELLAR_INDEX=5;
    public static final int BASEMENT_TEMPLATE_ID_UPDATE_INDEX=6;
    public static final String SELECT_BASEMENT_TEMPLATE = "SELECT * FROM BASEMENTTEMPLATE ";
    public static final String DELETE_BASEMENT_TEMPLATE = " DELETE FROM BASEMENTTEMPLATE WHERE id= (?)";
    public static final String UPDATE_BASEMENT_TEMPLATE = "UPDATE BASEMENTTEMPLATE SET id=(?), name=(?), pricemultiplier=(?),id_material=(?),cellar=(?) WHERE id=(?)";
    
    public static final String INSERT_BUILDING_TEMPLATE = "INSERT INTO BUILDINGTEMPLATE VALUES (?,?,?,?,?)";
    public static final String BUILDING_TEMPLATE_ID = "id";
    public static final String BUILDING_TEMPLATE_NAME = "name";
    public static final String BUILDING_TEMPLATE_ID_ROOF_TEMPLATE = "id_roof_template";
    public static final String BUILDING_TEMPLATE_ID_MAIN_PART_TEMPLATE = "id_main_part_template";
    public static final String BUILDING_TEMPLATE_ID_BASEMENT_TEMPLATE = "id_basement_template";
    public static final int BUILDING_TEMPLATE_ID_INDEX=1;
    public static final int BUILDING_TEMPLATE_NAME_INDEX=2;
    public static final int BUILDING_TEMPLATE_ID_ROOF_TEMPLATE_INDEX=3;
    public static final int BUILDING_TEMPLATE_ID_MAIN_PART_TEMPLATE_INDEX=4;
    public static final int BUILDING_TEMPLATE_ID_BASEMENT_TEMPLATE_INDEX=5;
    public static final int BUILDING_TEMPLATE_ID_UPDATE_INDEX=6;
    public static final String SELECT_BUILDING_TEMPLATE = "SELECT * FROM BUILDINGTEMPLATE ";
    public static final String DELETE_BUILDING_TEMPLATE = " DELETE FROM BUILDINGTEMPLATE WHERE id= (?)";
    public static final String UPDATE_BUILDING_TEMPLATE = "UPDATE BUILDINGTEMPLATE SET id=(?), name=(?), id_roof_template=(?),id_main_part_template=(?),id_basement_template=(?) WHERE id=(?)";
    
    public static final String DEFAULT = "default";
    public static final String ACTOR = "System";
    public static final String DATABASE_NAME = "test";
    public static final String COLLECTION_NAME = "historyContent";
    public static final String MONGO_CLIENT = "mongodb://localhost:27017";
    public static final String MONGO_DATE_PATTERN = "yyyy.MM.dd HH:mm:ss";
    
}
