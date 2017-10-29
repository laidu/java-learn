package org.laidu.learn.hadoop.hdfs;

import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import org.apache.hadoop.conf.Configuration; import org.apache.hadoop.fs.BlockLocation; import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus; import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

/**
 * view files list
 * <p>
 * Created by tiancai.zang on 2017-10-19 13:53.
 */
@Slf4j
public class Ls {

    public static void main(String[] args) throws Exception {
        String uri = "hdfs://hadoop-master:9000/";

        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config, "root");

        FileStatus[] listStatus = fs.listStatus(new Path("/")); for (FileStatus file : listStatus) {
            System.out.println("[" + (file.isFile() ? "file" : "dir") + "] " + file.getPath().getName());
        }

        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);
        while (listFiles.hasNext()) {

            LocatedFileStatus fileStatus = listFiles.next();

            log.info("block size:{}",fileStatus.getBlockSize());
            log.info("owner : {}", fileStatus.getOwner());
            log.info("replication : {}" ,fileStatus.getReplication());
            log.info("permission : {}", fileStatus.getPermission());
            log.info("path name : {}",fileStatus.getPath().getName());

            log.info("========block info=========");

            BlockLocation[] blockLocations = fileStatus.getBlockLocations();

            for (BlockLocation blockLocation : blockLocations){

                log.info("block offset : {}",blockLocation.getOffset());
                log.info("block length : {}",blockLocation.getLength());

                String[] dataNodes = blockLocation.getHosts();
                for (String dataNode : dataNodes){
                    log.info("dataNode :{}",dataNode);
                }
            }
        }
    }
}