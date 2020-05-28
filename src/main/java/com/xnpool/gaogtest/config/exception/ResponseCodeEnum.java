package com.xnpool.gaogtest.config.exception;

/**
 * 常用返回码
 */
public enum ResponseCodeEnum {

    SUCCESS(100,"成功"),
    //系统相关 10 01
    TOKEN_EMPTY(1001,"token为空"),
    TOKEN_INVALID(1001,"请登录"),
    PARAMTER_LOSE(1002,"参数缺失"),
    PARAMTER_ERROR(1003,"参数错误"),
    SIGN_FAILURE(1004,"验签失败"),
    FORBID_REPEAT(1005,"操作过快"),
    VERIFYCODE_ERROR(1006,"验证码错误"),
    BIZ_ERROR(1007,"业务异常"),
    TOKEN_ANOTHER_PLACE(1008,"请登录"),
    NUMBER_LIMITATION_ERROR(1009,"次数超限"),
    //用户相关 11 01
    PASSWORD_ERROR(1101,"密码错误"),
    USER_UNKONW(1102,"用户不存在"),
    USER_EXIST(1103,"用户已存在"),
    USER_NON_REGISTER(1104,"用户未注册"),
    USER_ILLEGALITY (1105,"非法操作"),
    USER_ADDR_LIMIT(1106,"用户地址数目超出限制"),
    USER_FOLLOW_OWN(1107,"不能关注自己"),
    USER_NICKNAME_EXIST(1108,"昵称已存在"),

    //订单相关 12 01
    ORDER_FAIL (1201,"订单创建失败"),
    ORDER_SK_FAIL (1202,"订单创建失败"),
    ORDER_DETAILTK_FAIL (1203,"退款失败"),


    //作品相关 13 01
    WORK_UNREAL(1301,"作品不存在"),

    //支付相关
    PAY_TYPE_NON_ERROR(1401,"支付方式暂不支持"),

    //购物车
    CART_FAIL(1501,"添加购物车失败"),

    //物流信息
    EXPRESS_INFO(1601,"暂时没有物流信息"),

    //商品不存在
    PRODUCT_UNREAL(1701,"商品不存在或已下架"),
    //优惠券相关
    COUPON_NON_ERROR(1801,"优惠券不存在"),
    COUPON_PUT_OUT_ERROR(1802,"优惠券已领完"),
    //投票
    VOTE_ALL_INFO(1901,"暂时没有相应信息"),
    VOTE_NUM_INFO(1902,"暂时没有投票机会"),
    ;

    private int code;

    private String message;

     ResponseCodeEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
