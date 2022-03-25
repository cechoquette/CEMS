package CEMS.src.application;

public enum PermissionType {

    ADMIN("Admin"),
    ADMIN_PLUS("Admin+"),
    SUPER_ADMIN("SuperAdmin");

    private String typeName;

    PermissionType(String typeName){
        this.typeName = typeName;
    }

    @Override
    public String toString() { return typeName; }


}
