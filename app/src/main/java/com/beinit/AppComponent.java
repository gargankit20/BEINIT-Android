package com.beinit;


import com.common.BaseApplication;
import com.common.base.dagger.BaseComponent;

import dagger.Component;

@AppScope
@Component(dependencies = BaseComponent.class, modules = {AppModule.class})
public interface AppComponent extends AppGraph {

    void inject(AppApplication application);

    final class Initializer {
        private Initializer() {
        }

        static AppComponent init(BaseApplication app) {
            return DaggerAppComponent.builder()
                    .baseComponent(app.getBaseComponent())
                    .appModule(new AppModule(app))
                    .build();
        }
    }
}
