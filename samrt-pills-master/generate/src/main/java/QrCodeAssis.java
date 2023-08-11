import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;


/**
 * 生成二维码
 */
public class QrCodeAssis {




    public static void main(String[] args) {

        QrCodeUtil.generate("991017951247", 468, 468, FileUtil.file("e:/qrcode.jpg"));
    }
}



/**
 * @Copyright  : www.codecoord.com Inc. All rights reserved.
 * @Author     : 田鑫
 * @CreateDate : 2018/9/24 10:32
 * @Version    : V1.0
 * @Description: 主方法
 */



