package ${package}.client.home;

import ${package}.client.home.HomeView.Presenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HomeViewImpl extends Composite implements HomeActivity.View {

	private static HomeViewImplUiBinder uiBinder = GWT
			.create(HomeViewImplUiBinder.class);

	interface HomeViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
	}

	private Presenter presenter;

	@UiField
	Button detailsButton;

	@UiField
	Button sayHeloButton;
	
	@UiField
	Button heloActionButton;
	
	public HomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("detailsButton")
	void handleDetailsButtonClick(ClickEvent e) {
		presenter.goToDetails();
	}

	@UiHandler("sayHeloButton")
	void handleHeloButtonClick(ClickEvent e) {
		presenter.sayHelo("world");
	}
	
	@UiHandler("heloActionButton")
	void handleHeloActionButtonClick(ClickEvent e) {
		presenter.sendHeloAction("world");
	}
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
}
