package me.arganzheng.project.reading.common;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

/**
 * <pre>
 * ConditionTypeHandler:
 *  cid1, cid2, cid3.. <==> List<String> conditionIdList
 * 
 * </pre>
 */
public class StringListTypeHandler implements TypeHandlerCallback {

    @SuppressWarnings("unchecked")
    @Override
    public void setParameter(ParameterSetter setter, Object parameter) throws SQLException {
        if (null == parameter) {
            setter.setNull(Types.VARCHAR);
            return;
        }

        List<String> paramList = (List<String>) parameter;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paramList.size(); i++) {
            String cid = paramList.get(i);
            sb.append(cid);
            if (i < paramList.size() - 1) {
                sb.append(",");
            }
        }
        setter.setString(sb.toString());
    }

    @Override
    public Object getResult(ResultGetter getter) throws SQLException {
        String str = getter.getString();
        if (StringUtils.isBlank(str)) {
            return Collections.emptyList();
        }

        List<String> paramList = new ArrayList<String>();

        String[] values = str.split(",");
        for (String c : values) {
            if (StringUtils.isNotBlank(c)) {
                paramList.add(c.trim());
            }
        }

        return paramList;
    }

    @Override
    public Object valueOf(String s) {
        List<String> paramList = new ArrayList<String>();

        String[] values = s.split(",");
        for (String c : values) {
            if (StringUtils.isNotBlank(c)) {
                paramList.add(c.trim());
            }
        }

        return paramList;
    }

}
