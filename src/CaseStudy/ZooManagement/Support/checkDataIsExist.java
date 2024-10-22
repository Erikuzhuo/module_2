package CaseStudy.ZooManagement.Support;

import CaseStudy.ZooManagement.Model.Class.ZooAnimal;
import CaseStudy.ZooManagement.Model.Class.Admin;

import java.util.List;
import java.util.Objects;

public class checkDataIsExist {
    public static boolean checkAnimalExist(List<ZooAnimal> list, String ele) {
        for (ZooAnimal check : list) {
            if (ele.isEmpty() || Objects.equals(check.getID(), ele)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkAnimalExist(ZooAnimal[] list, String ele) {
        for (ZooAnimal check : list) {
            if (ele.isEmpty() || Objects.equals(check.getID(), ele)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkStaffExist(List<Admin> list, String ele) {
        for (Admin check : list) {
            if (ele.isEmpty() || Objects.equals(check.getID(), ele)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkStaffExist(Admin[] list, String ele) {
        for (Admin check : list) {
            if (ele.isEmpty() || Objects.equals(check.getID(), ele)) {
                return true;
            }
        }
        return false;
    }

}
