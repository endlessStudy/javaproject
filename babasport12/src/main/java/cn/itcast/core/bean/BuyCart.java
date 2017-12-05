package cn.itcast.core.bean;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 购物车
 * @author lx
 *
 */
public class BuyCart {

	//购物项  集合
	
	List<BuyItem> items = new ArrayList<BuyItem>();
	//继续购物   最后一款
	private Integer productId;
	
	
	//添加方法
	public void addItem(BuyItem item){
		//判断是否重复
		if(items.contains(item)){
			for(BuyItem it : items){
				if(it.equals(item)){
					//  7     5  3    7
					int result = it.getAmount() + item.getAmount();
					if(it.getSku().getSkuUpperLimit() >= result){
						it.setAmount(result);
					}else{
						it.setAmount(it.getSku().getSkuUpperLimit());
					}
				}
			}
			
		}else{
			
			items.add(item);
		}
	}
	//删除一个
	public void deleteItem(BuyItem item){
		items.remove(item);
	}
	//小计
	//商品数量
	@JsonIgnore
	public int getProductAmount(){
		int result = 0;
		for(BuyItem item : items){
			result += item.getAmount();
		}
		return result;
	}
	//商品金额
	@JsonIgnore
	public Double getProductPrice(){
		Double result = 0.00;
		for(BuyItem item : items){
			result += item.getSku().getSkuPrice()*item.getAmount();
		}
		return result;
	}
	//运费
	@JsonIgnore
	public Double getFee(){
		Double result = 0.00;
		if(getProductPrice() <= 39){
				result = 10.00;
		}
		return result;
	}
	
	//清空购物车
	public void clearCart(){
		items.clear();
	}
	//应付金额
	@JsonIgnore
	public Double getTotalPrice(){
		return getFee() + getProductPrice();
	}

	public List<BuyItem> getItems() {
		return items;
	}

	public void setItems(List<BuyItem> items) {
		this.items = items;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	
	//小计
	
	
	
	
	
}
