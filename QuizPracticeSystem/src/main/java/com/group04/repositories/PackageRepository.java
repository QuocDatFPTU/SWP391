/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Packages;
import java.util.List;

/**
 *
 * @author ntdun
 */
public interface PackageRepository {
    public void addPackage(Packages packages);
    public void deletePackage(Long packageID);
    public void updatePackage(Packages packages);
    List<Package> getAllPackageBySubjectID(Long subjectID);
    Package getPackageByPackageId(Long packageId);
}