SELECT round((df.bytes - nvl(sum(fs.bytes),0)) * 100 / df.maxbytes,2) result
FROM dba_free_space fs,
     (SELECT tablespace_name, sum(bytes) bytes, sum(decode(abs(maxbytes-bytes), maxbytes-bytes, maxbytes, 0, bytes, bytes)) maxbytes
      FROM dba_data_files
      GROUP BY tablespace_name) df
WHERE fs.tablespace_name(+)  = df.tablespace_name and df.tablespace_name=?
GROUP BY df.tablespace_name, df.bytes, df.maxbytes