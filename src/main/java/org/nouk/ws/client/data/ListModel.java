//package org.nouk.ws.client.data;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.swing.*;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Component
//public class ListModel extends AbstractListModel {
//    private ManualListModel manualListModel;
//    @Autowired
//    public void setManualListModel(ManualListModel manualListModel) {
//        this.manualListModel = manualListModel;
//    }
//
//    @Override
//    public int getSize() {
//        if (manualListModel==null) {
//            return 0;
//        }
//        return manualListModel.getDatas().keySet().size();
//    }
//
//    @Override
//    public Object getElementAt(int index) {
//        return manualListModel.getDatas().keySet().stream().collect(Collectors.toList()).get(index);
//    }
//
//    public void addData(String key,String data){
//        manualListModel.getDatas().put(key,data);
//    }
//
//    public String getData(String key){
//        return manualListModel.getDatas().get(key);
//    }
//
//    public void removeData(String key){
//        manualListModel.getDatas().remove(key);
//    }
//}
