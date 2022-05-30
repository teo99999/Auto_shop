package com.informatics.cscb869f2020week7.data.entity;

public enum RepairType {
    engineRepair(1), transmissionRepair(2), breaksRepair(3), replacementOfConsumables(4);

    private final int id;

    RepairType(int i) {
        id = i;
    }

    public int getId() {
        return id;
    }
}
