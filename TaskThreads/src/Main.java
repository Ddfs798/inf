public class Main {
    public static void main(String[] args) {

        Thread projectThread = new Thread(new ProjectJob()); // 1
        Thread projectWindow = new Thread(new WindowFabrication(projectThread));// 2 изготовление окон
        Thread projectDoors = new Thread(new DoorFabrication(projectThread));// 3 изготовление дверей
        Thread projectFundament = new Thread(new FoundationErection(projectThread));// 4 возведение фундамента
        Thread projectCommunications = new Thread(new Communications(projectFundament));// 5 коммуникации
        Thread projectWalls = new Thread(new WallConstruction(projectFundament));// 6 возведение стен
        Thread projectRoof = new Thread(new RoofErection(projectWalls));// 7 возведение крыши
        Thread projectWindowsInstall = new Thread(new WindowInstall(projectRoof, projectWindow));// 8 установка окон
        Thread projectDoorsInstall = new Thread(new DoorInstall(projectRoof, projectDoors));// 9 установка дверей
        Thread projectBattery = new Thread(new BatteryInstall(projectCommunications, projectWindowsInstall, projectDoorsInstall));// 10 установка отопительных приборов (батарей)
        Thread projectElectric = new Thread(new Electric(projectCommunications, projectRoof));// 11 прокладка электропроводки
        Thread projectWallAndCeiling = new Thread(new WallCeilingFinishing(projectWindowsInstall, projectDoorsInstall, projectElectric));// 12 отделка стен и потолка
        Thread projectFloor = new Thread(new FloorFinish(projectWallAndCeiling));// 13 отделка пола
        Thread projectLightingInstall = new Thread(new lightingInstall(projectWallAndCeiling));// 14 установка осветительных приборов
        Thread projectPlumbing = new Thread(new Plumbing(projectCommunications, projectElectric, projectWallAndCeiling));// 15 установка сантехники
        Thread projectEnd = new Thread(new EndBuiding(projectFloor, projectPlumbing, projectLightingInstall)); // 16 завершение строительства
        Thread projectBricklayers = new Thread(new Bricklayers(projectWalls, projectEnd));
        Thread projectСarpenters = new Thread(new Сarpenters(projectDoorsInstall, projectEnd)); // плотник
        Thread projectSatnechs = new Thread(new Satnechs(projectPlumbing, projectEnd));
        Thread projectPlasterers = new Thread(new Plasterers(projectFloor, projectEnd));
        Thread projectElectricians = new Thread(new Electricians(projectLightingInstall, projectEnd));



        projectThread.start();
        projectWindow.start();
        projectDoors.start();
        projectFundament.start();
        projectCommunications.start();
        projectWalls.start();
        projectRoof.start();
        projectWindowsInstall.start();
        projectDoorsInstall.start();
        projectBattery.start();
        projectElectric.start();
        projectWallAndCeiling.start();
        projectFloor.start();
        projectLightingInstall.start();
        projectPlumbing.start();
        projectEnd.start();

        projectСarpenters.start();
        projectBricklayers.start();
        projectSatnechs.start();
        projectPlasterers.start();
        projectElectricians.start();

    }
}