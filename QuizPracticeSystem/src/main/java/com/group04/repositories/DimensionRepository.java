/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Dimension;
import java.util.List;

/**
 *
 * @author ntdun
 */
public interface DimensionRepository {
    public void addDimension(Dimension dimension);
    public void deleteDimension(Long dimensionID);
    public void updateDimension(Dimension dimension);
    public List<Dimension> getDimensionBySubjectID(Long subjectID);
}
