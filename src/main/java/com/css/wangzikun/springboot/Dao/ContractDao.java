package com.css.wangzikun.springboot.Dao;


import com.css.wangzikun.springboot.Entity.Contract;
import com.css.wangzikun.springboot.Entity.Order;
import com.sun.xml.bind.v2.model.core.ID;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ContractDao {

//    @Insert("insert into wangzikun_contract values(#{contractId},#{partyA},#{partyB},#{createDate},#{contractInfo})")
//    public void createContract(@Param("contractId") int contractId,  @Param("partyA") String partyA, @Param("partyB") String partyB,@Param("createDate") Date createDate, @Param("contractInfo") String contractInfo);

    @Select("select * from wangzikun_contract")
    public List<Contract> showContract();
    @Insert("insert into wangzikun_contract values(#{id},#{party_a},#{party_b},#{create_date},#{contract_info})")
    public void createContract(@Param("id")int id
            ,@Param("party_a") String party_a
            ,@Param("party_b")String party_b
            ,@Param("create_date")String create_date
            ,@Param("contract_info")String contract_info);

    @Delete("delete from wangzikun_contract where contract_id=#{id}")
    public void deleteContractById(int id);

    @Update("update wangzikun_contract set contract_info = #{info} where contract_id=#{id}")
    public void updateInfo(@Param("id") int id , @Param("info") String info);

    @Update("update wangzikun_contract set party_a=#{party_a},party_b=#{party_b},contract_info=#{contract_info} where contract_id=#{contract_id}")
    public void updateContract(Contract contract);

    //根据ID查询合同是否存在
    @Select("select count(1) from wangzikun_contract where contract_id = #{id}")
    public int isContractExcist(int id);

    @Select("select * from wangzikun_contract where contract_id = #{id}")
    public Contract showContractById(int id);

    @Insert("insert into wangzikun_contract values(#{contract_id},#{party_a},#{party_b},#{create_date},#{contract_info})")
    public void insertContract(Contract contract);
}
