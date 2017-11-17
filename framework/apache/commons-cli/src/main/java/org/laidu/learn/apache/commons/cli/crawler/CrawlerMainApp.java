package org.laidu.learn.apache.commons.cli.crawler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;
import org.laidu.learn.apache.commons.cli.crawler.enums.CrawlerType;

/**
 * crawler start app
 * <p>
 * Created by tiancai.zang on 2017-11-15 18:45.
 */
@Slf4j
public class CrawlerMainApp {

    public static void main(String[] args) throws ParseException {

        Option opt = Option.builder("t").hasArg()
                .required(true)
                .type(CrawlerType.class)
                .longOpt("service.type")
                .valueSeparator('=')
                .argName(" reg | laolai | search | bankApi | searchEngine ")
                .desc("服务类型")
                .build();

        Option opt2 = Option.builder("p").hasArg()
                .type(Boolean.class)
                .longOpt("use.proxy")
                .argName(" true | false ")
                .valueSeparator('=')
                .desc("是否使用代理")
                .build();

        Option opt3 = Option.builder("c").hasArgs()
                .type(Integer.class)
                .longOpt("max.service.count")
                .valueSeparator('=')
                .argName(" num ")
                .desc("启动网站数")
                .build();

        Options options = new Options();
        options.addOption(opt);
//        options.addOption(opt2);
//        options.addOption(opt3);

        String[] argsA = {"-t=reg", "-use.proxy1=true", "-max.service.count=12"};


        CommandLineParser parser = new DefaultParser();

        CommandLine line = parser.parse(options, argsA,false);

        for (Option option : line.getOptions()) {
            System.out.print(option.getLongOpt() + ": \t");

            if (CrawlerType.class.equals(option.getType())){
                try {
                    CrawlerType.valueOf(option.getValue().toUpperCase());
                }catch (Exception e){
                    throw new MissingArgumentException(String.format("无效的选项参数：%s",option.getValue()));
                }
            }

            for (String value : option.getValues()) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

        HelpFormatter formatter = new HelpFormatter();
        formatter.setWidth(500);
        formatter.printHelp("help", options);
    }
}