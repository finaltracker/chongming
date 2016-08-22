declare 
      cnt   number;
	  V_NUM number;
	  T_NUM number;
begin 
      select count(*) into cnt from user_tables where TABLE_NAME = 'CM_STATISTICS'; 
      if   cnt>0   then 
          execute immediate 'drop table CM_STATISTICS';
		  commit;
      end   if; 
      
      select count(*) into cnt from user_tables where TABLE_NAME = 'CM_COUNTRY'; 
      if   cnt>0   then 
          execute immediate 'drop table CM_COUNTRY';
		  commit;
      end   if; 

      select count(*) into cnt from user_tables where TABLE_NAME = 'CM_LEVEL'; 
      if   cnt>0   then 
          execute immediate 'drop table CM_LEVEL';
		  commit;
      end   if; 
	  
      select count(*) into cnt from user_tables where TABLE_NAME = 'CM_LOG'; 
      if   cnt>0   then 
          execute immediate 'drop table CM_LOG';
          commit;
      end   if; 

      select count(*) into cnt from user_tables where TABLE_NAME = 'CM_PART'; 
      if   cnt>0   then 
          execute immediate 'drop table CM_PART';
          commit;
      end   if; 

      select count(*) into cnt from user_tables where TABLE_NAME = 'CM_PERSON'; 
      if   cnt>0   then 
          execute immediate 'drop table CM_PERSON';
          commit;
      end   if; 

      select count(*) into cnt from user_tables where TABLE_NAME = 'CM_RECORD'; 
      if   cnt>0   then 
          execute immediate 'drop table CM_RECORD';
          commit;
      end   if; 

      select count(*) into cnt from user_tables where TABLE_NAME = 'CM_ROLE'; 
      if   cnt>0   then 
          execute immediate 'drop table CM_ROLE';
          commit;
      end   if; 

      select count(*) into cnt from user_tables where TABLE_NAME = 'CM_TARGET'; 
      if   cnt>0   then 
          execute immediate 'drop table CM_TARGET';
          commit;
      end   if; 

    
    V_NUM := 0;  
    
    select count(0) into V_NUM from user_sequences where sequence_name = 'SEQ_CM_STATISTICS'; 
    
    if V_NUM > 0 then   
		execute immediate 'DROP SEQUENCE  SEQ_CM_STATISTICS';
		commit;	  
    end if;
    
    V_NUM := 0;  
    
    select count(0) into V_NUM from user_sequences where sequence_name = 'SEQ_CM_COUNTRY'; 
    
    if V_NUM > 0 then   
		execute immediate 'DROP SEQUENCE  SEQ_CM_COUNTRY';
		commit;	  
    end if;
    
    
    V_NUM := 0;  
    
    select count(0) into V_NUM from user_sequences where sequence_name = 'SEQ_CM_LEVEL'; 
    
    if V_NUM > 0 then   
		execute immediate 'DROP SEQUENCE  SEQ_CM_LEVEL'; 
		commit;
    end if;
    
    
    V_NUM := 0;  
    
    select count(0) into V_NUM from user_sequences where sequence_name = 'SEQ_CM_LOG'; 
    
    if V_NUM > 0 then   
		execute immediate 'DROP SEQUENCE  SEQ_CM_LOG';
		commit;
    end if;
    
    
    V_NUM := 0;  
    
    select count(0) into V_NUM from user_sequences where sequence_name = 'SEQ_CM_PART'; 
    
    if V_NUM > 0 then   
		execute immediate 'DROP SEQUENCE  SEQ_CM_PART'; 
		commit;
    end if;
    
    
    V_NUM := 0;  
    
    select count(0) into V_NUM from user_sequences where sequence_name = 'SEQ_CM_RECORD'; 
    
    if V_NUM > 0 then   
		execute immediate 'DROP SEQUENCE  SEQ_CM_RECORD'; 
		commit;
    end if;
    
    
    V_NUM := 0;  
    
    select count(0) into V_NUM from user_sequences where sequence_name = 'SEQ_CM_ROLE'; 
    
    if V_NUM > 0 then   
		execute immediate 'DROP SEQUENCE  SEQ_CM_ROLE'; 
		commit;
    end if;
    
    
    V_NUM := 0;  
    
    select count(0) into V_NUM from user_sequences where sequence_name = 'SEQ_CM_TARGET'; 
    
    if V_NUM > 0 then   
		execute immediate 'DROP SEQUENCE  SEQ_CM_TARGET'; 
		commit;
    end if;
    
    
    V_NUM := 0;  
    
    select count(0) into V_NUM from user_sequences where sequence_name = 'SEQ_CM_PERSON'; 
    
    if V_NUM > 0 then   
		execute immediate 'DROP SEQUENCE  SEQ_CM_PERSON'; 
		commit;
    end if;    

	
    T_NUM := 0;  
    
    select count(0) into T_NUM from user_triggers where trigger_name = 'tig_cm_statistics'; 
    
    if T_NUM > 0 then   
      execute immediate 'DROP TRIGGER  tig_cm_statistics'; 
      commit;
    end if;
    
    T_NUM := 0;  
    
    select count(0) into T_NUM from user_triggers where trigger_name = 'tig_cm_country'; 
    
    if T_NUM > 0 then   
      execute immediate 'DROP TRIGGER  tig_cm_country'; 
      commit;
    end if;
    
   
    T_NUM := 0;  
    
    select count(0) into T_NUM from user_triggers where trigger_name = 'tig_cm_level'; 
    
    if T_NUM > 0 then   
      execute immediate 'DROP TRIGGER  tig_cm_level'; 
      commit;
    end if;
    
   
    T_NUM := 0;  
    
    select count(0) into T_NUM from user_triggers where trigger_name = 'tig_cm_log'; 
    
    if T_NUM > 0 then   
      execute immediate 'DROP TRIGGER  tig_cm_log'; 
      commit;
    end if;
    
   
    T_NUM := 0;  
    
    select count(0) into T_NUM from user_triggers where trigger_name = 'tig_cm_part'; 
    
    if T_NUM > 0 then   
      execute immediate 'DROP TRIGGER  tig_cm_part'; 
      commit;
    end if;
    
   
    T_NUM := 0;  
    
    select count(0) into T_NUM from user_triggers where trigger_name = 'tig_cm_person'; 
    
    if T_NUM > 0 then   
      execute immediate 'DROP TRIGGER  tig_cm_person'; 
      commit;
    end if;
    
   
    T_NUM := 0;  
    
    select count(0) into T_NUM from user_triggers where trigger_name = 'tig_cm_record'; 
    
    if T_NUM > 0 then   
      execute immediate 'DROP TRIGGER  tig_cm_record'; 
      commit;
    end if;
    
   
    T_NUM := 0;  
    
    select count(0) into T_NUM from user_triggers where trigger_name = 'tig_cm_role'; 
    
    if T_NUM > 0 then   
      execute immediate 'DROP TRIGGER  tig_cm_role'; 
      commit;
    end if;
    
   
    T_NUM := 0;  
    
    select count(0) into T_NUM from user_triggers where trigger_name = 'tig_cm_target'; 
    
    if T_NUM > 0 then   
      execute immediate 'DROP TRIGGER  tig_cm_target'; 
      commit;
    end if;
END;