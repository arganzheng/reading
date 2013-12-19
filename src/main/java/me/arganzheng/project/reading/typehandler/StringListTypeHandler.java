package me.arganzheng.project.reading.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * <pre>
 * ConditionTypeHandler:
 *  cid1, cid2, cid3.. <==> List<String> conditionIdList
 * 
 * </pre>
 */
public class StringListTypeHandler implements TypeHandler {

    @Override
    public void setParameter(PreparedStatement ps, int index, Object obj, JdbcType type) throws SQLException {
        if (obj == null) {
            ps.setNull(index, Types.VARCHAR);
            return;
        }

        List<String> paramList = (List<String>) obj;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paramList.size(); i++) {
            String cid = paramList.get(i);
            sb.append(cid);
            if (i < paramList.size() - 1) {
                sb.append(",");
            }
        }

        ps.setString(index, sb.toString());
    }

    @Override
    public Object getResult(ResultSet rs, String col) throws SQLException {
        String str = rs.getString(col);
        return getListFromString(str);
    }

    private Object getListFromString(String str) {
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
    public Object getResult(ResultSet rs, int col) throws SQLException {
        String str = rs.getString(col);
        return getListFromString(str);
    }

    @Override
    public Object getResult(CallableStatement cs, int col) throws SQLException {
        String str = cs.getString(col);
        return getListFromString(str);
    }
}
