package CaseStudy.ZooManagement.Controller;

import CaseStudy.ZooManagement.Model.ZooAnimal;
import CaseStudy.ZooManagement.Model.ZooStaff;

import java.util.List;
import java.util.Objects;

public class checkDataIsExist {
    public static boolean checkAnimalExist(List<ZooAnimal> list, String ele) {
        for (ZooAnimal check : list) {
            if (Objects.equals(check.getID(), ele)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkAnimalExist(ZooAnimal[] list, String ele) {
        for (ZooAnimal check : list) {
            if (Objects.equals(check.getID(), ele)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkStaffExist(List<ZooStaff> list, String ele) {
        for (ZooStaff check : list) {
            if (Objects.equals(check.getID(), ele)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkStaffExist(ZooStaff[] list, String ele) {
        for (ZooStaff check : list) {
            if (Objects.equals(check.getID(), ele)) {
                return true;
            }
        }
        return false;
    }

}
