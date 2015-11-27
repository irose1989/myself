package test.authorizer.permission;

import com.alibaba.druid.util.StringUtils;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;

/**
 * Created by wb-chenchaobin on 2015/11/27.
 */
public class BitPermission implements Permission {
    private String resourceIdentify;
    private Integer permissionBit;
    private String instanceId;
    public  BitPermission(String permissionStr){
        String[]prams = permissionStr.split("//+");
        if(prams.length>1){
            resourceIdentify = prams[1];
        }
        if(StringUtils.isEmpty(resourceIdentify)){
            resourceIdentify="*";
        }
        if(prams.length>2){
            permissionBit = Integer.valueOf(prams[2]);
        }
        if(prams.length > 3) {
            instanceId = prams[3];
        }
        if(StringUtils.isEmpty(instanceId)) {
            instanceId = "*";
        }
    }
    @Override
    public boolean implies(Permission permission) {
        if(!(permission instanceof BitPermission)) {
            return false;
        }
        BitPermission other = (BitPermission) permission;

        if(!("*".equals(this.resourceIdentify) || this.resourceIdentify.equals(other.resourceIdentify))) {
            return false;
        }

        if(!(this.permissionBit ==0 || (this.permissionBit & other.permissionBit) != 0)) {
            return false;
        }

        if(!("*".equals(this.instanceId) || this.instanceId.equals(other.instanceId))) {
            return false;
        }
        return true;
    }
}
