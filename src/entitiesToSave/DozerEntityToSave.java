package entitiesToSave;

public class DozerEntityToSave implements SavableToDB{
    //Сущнность бульдозера, которая формируется перед внесением в БД

    //Номер заявки
    private int request;
    //Модификация бульдозера
    private int doz_modification;
    //Конфигурация трансмиссии
    private int id_transmission;
    //Конфигурация ДВС
    private int id_disel;
    //Конфигурация системы охлаждения
    private int id_coolant_system;
    //Конфигурация навесного оборудования
    private int id_attachments;
    //Конфигурация ходовой части
    private int id_bogies;
    //Конфигурация кабины
    private int id_cabin;
    //Конфигурация электрооборудования
    private int id_electrics;
    //Номер КД ЗИП
    private int id_spare_tools;

    @Override
    public int saveToDB() {
        return 0;
    }
}
