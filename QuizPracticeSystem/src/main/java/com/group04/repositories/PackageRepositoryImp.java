/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Packages;
import com.group04.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ntdun
 */
public class PackageRepositoryImp implements PackageRepository {

    @Override
    public void addPackage(Packages packages) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(packages);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deletePackage(Long packageID) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Packages packages = session.get(Packages.class, packageID);
            if (packages != null) {
                session.delete(packages);
                System.out.println("Package is deleted");
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

        }
    }

    @Override
    public void updatePackage(Packages packages) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(packages);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Package getPackageByPackageId(Long packageId) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Package pkg = (Package) session.createQuery("FROM Package P WHERE P.packageId = :packageId").setParameter("packageId",packageId)
                    .getSingleResult();
            transaction.commit();
            return pkg;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Package> getAllPackageBySubjectID(Long subjectID) {
        Transaction transaction = null;
        List<Package> packages = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            packages = session.createQuery("FROM Subject S WHERE S.subjectID = :id").setParameter("id", subjectID)
                    .getResultList();
            if (packages != null) {
                return packages;
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("loi except :" +e);
            if (transaction != null) {
                System.out.println("Loop Function");
                transaction.rollback();
            }
        }
        return null;    
    }

}
