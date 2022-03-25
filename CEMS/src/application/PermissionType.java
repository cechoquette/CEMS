package CEMS.src.application;

public enum PermissionType {

    ADMIN("Admin"),
    ADMIN_PLUS("Admin+"),
    SUPER_ADMIN("SuperAdmin");

    private String permissionName;

    PermissionType(String permissionName){
        this.permissionName = permissionName;
    }

    @Override
    public String toString() { return permissionName; }


}
