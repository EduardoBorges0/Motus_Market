// Generated by Dagger (https://dagger.dev).
package com.app.motus_finance.presentation.viewmodel;

import com.app.motus_finance.domain.usecases.GraphicsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class GraphicsViewModel_Factory implements Factory<GraphicsViewModel> {
  private final Provider<GraphicsUseCase> graphicsUseCasesProvider;

  public GraphicsViewModel_Factory(Provider<GraphicsUseCase> graphicsUseCasesProvider) {
    this.graphicsUseCasesProvider = graphicsUseCasesProvider;
  }

  @Override
  public GraphicsViewModel get() {
    return newInstance(graphicsUseCasesProvider.get());
  }

  public static GraphicsViewModel_Factory create(
      Provider<GraphicsUseCase> graphicsUseCasesProvider) {
    return new GraphicsViewModel_Factory(graphicsUseCasesProvider);
  }

  public static GraphicsViewModel newInstance(GraphicsUseCase graphicsUseCases) {
    return new GraphicsViewModel(graphicsUseCases);
  }
}
